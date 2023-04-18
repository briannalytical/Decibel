package com.techelevator.controller;

import com.techelevator.dao.GenreDao;
import com.techelevator.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class GenreController {

    @Autowired
    private GenreDao genreDao;

    @RequestMapping(path = "/songs/genres", method = RequestMethod.GET)
    public List<Genre> getGenres() {
        return genreDao.getGenres();
    }


}
