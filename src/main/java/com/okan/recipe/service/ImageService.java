package com.okan.recipe.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Author:   Okan Hollander
 * Date:     04/01/2020
 * Time:     11:56
 */
public interface ImageService {

    void saveImageFile(Long recipeId, MultipartFile file);
}
