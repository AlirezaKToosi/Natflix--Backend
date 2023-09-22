package com.novare.natflixbackend.services.contents;

import com.novare.natflixbackend.models.contents.Content;
import com.novare.natflixbackend.repositories.contents.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public Content findByContentType(String type) {
        Optional<Content> matchingContent = contentRepository.findAll()
                .stream()
                .filter(content -> content.getContentType().getType().equalsIgnoreCase(type))
                .findFirst();

        return matchingContent.orElse(null);
    }
    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

    public Optional<Content> findContentById(Integer contentId) {
        return contentRepository.findById(contentId);
    }

    public void deleteContent(Content content) {
        contentRepository.delete(content);
    }

    public void saveContent(Content content) {
        contentRepository.save(content);
    }
}