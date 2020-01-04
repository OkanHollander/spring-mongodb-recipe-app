package com.okan.recipe.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author:   Okan Hollander
 * Date:     04/01/2020
 * Time:     11:57
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService{


    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {
      log.debug("received a file...");
    }
}
