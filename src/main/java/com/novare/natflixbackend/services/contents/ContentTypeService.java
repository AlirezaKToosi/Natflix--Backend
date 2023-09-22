package com.novare.natflixbackend.services.contents;


import com.novare.natflixbackend.models.contents.ContentType;
import com.novare.natflixbackend.repositories.contents.ContentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ContentTypeService {
    @Autowired
    private ContentTypeRepository contentTypeRepository;

    public Optional<ContentType> findContentTypeById(Integer ContentTypeId) {
        return contentTypeRepository.findById(ContentTypeId);
    }
}
