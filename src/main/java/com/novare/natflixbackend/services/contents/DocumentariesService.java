package com.novare.natflixbackend.services.contents;

import com.novare.natflixbackend.models.contents.Documentaries;
import com.novare.natflixbackend.repositories.contents.DocumentariesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentariesService {

    @Autowired
    private DocumentariesRepository documentariesRepository;

    public List<Documentaries> getAllDocumentaries() {
        return documentariesRepository.findAll();
    }

    public Optional<Documentaries> findDocumentaryById(Integer documentaryId) {
        return documentariesRepository.findById(documentaryId);
    }

    public void deleteDocumentary(Documentaries documentaries) {
        documentariesRepository.delete(documentaries);
    }

    public void saveDocumentary(Documentaries documentaries) {
        documentariesRepository.save(documentaries);
    }

}
