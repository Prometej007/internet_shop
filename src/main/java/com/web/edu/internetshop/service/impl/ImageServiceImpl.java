package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.product.Image;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.ImageRepository;
import com.web.edu.internetshop.service.ImageService;
import com.web.edu.internetshop.service.exceptions.SystemVariableNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static com.web.edu.internetshop.config.ApplicationWebMvcConfig.FILE_HOME;
import static java.util.Optional.ofNullable;

@Service
public class ImageServiceImpl implements ImageService {

    private static final Logger logger = Logger.getLogger(ImageServiceImpl.class.getName());

    private static String filePath = System.getenv(FILE_HOME);


    @Autowired
    private ImageRepository imageRepository;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Image create(Image image) {
        return save(
                setLastModification(
                        setDefaultAvailable(
                                setDateCreate(
                                        image.setPath(build(image))
                                )
                        )
                )
        );
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image findOne(Image image) {
        return findOne(image.getId());
    }

    @Override
    public Image findOne(Long id) {
        return imageRepository.findOne(id);
    }

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Image update(Image image) {
        return save(setLastModification(image.setPath(build(image))));
    }

    @Override
    public Image lastModification(LastModification<Image> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }


    private String build(Image img) throws RuntimeException {
        if (!ofNullable(System.getenv(FILE_HOME)).isPresent())
            throw new SystemVariableNotFoundException(FILE_HOME);
        String[] parts = img.getContent().split(",");
        String imageString = parts[1];

// create a buffered image
        BufferedImage image = null;
        byte[] imageByte;

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            imageByte = decoder.decodeBuffer(imageString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
        try {
            image = ImageIO.read(bis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

// write the image to a file
        File outputfile = new File(filePath + "/" + getImageName(img, getType(parts[0])));
        try {
            ImageIO.write(image, getType(parts[0]), outputfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return getImageName(img, getType(parts[0]));
    }

    private String getType(String t) {
        if (!t.startsWith("data:image"))
            throw new RuntimeException("not image");
        return t.substring(t.indexOf("/") + 1, t.indexOf(";"));
    }

    private String getImageName(Image image, String type) {
        return image.getId() + "." + type;
    }


}
