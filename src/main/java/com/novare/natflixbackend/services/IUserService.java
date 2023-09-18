package com.novare.natflixbackend.services;

import com.novare.natflixbackend.exceptions.BackEndException;
import com.novare.natflixbackend.models.User;

public interface IUserService {
    User createUser(User user) throws BackEndException;
}
