package com.novare.natflixbackend.services.contents;

import com.novare.natflixbackend.models.contents.ContentCategory;
import com.novare.natflixbackend.repositories.contents.ContentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ContentCategoryService {
    @Autowired
    private ContentCategoryRepository contentCategoryRepository;

    public Optional<ContentCategory> findContentCategoryById(Integer contentCategoryId) {
        return contentCategoryRepository.findById(contentCategoryId);
    }
}
