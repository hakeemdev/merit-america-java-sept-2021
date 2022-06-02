package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import com.techelevator.services.RestCatFactService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CatCard> list(){
        return catCardDao.list();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CatCard get(@PathVariable long id){
        return catCardDao.get(id);
    }

    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public CatCard getRandom(@RequestBody CatCard randomCard){
        CatCard card = new CatCard();
        card.setImgUrl(catPicService.getPic().getFile());
        card.setCatFact(catFactService.getFact().getText());
        card.setCaption("test");
        return card;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public boolean save(@Valid @RequestBody CatCard cardToSave) throws CatCardNotFoundException{
        return catCardDao.save(cardToSave);
    }

    @RequestMapping(path = "/saverandom", method = RequestMethod.POST)
    public boolean saveRandom() throws CatCardNotFoundException{
        CatCard card = new CatCard();
        return catCardDao.save(getRandom(card));
    }



    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public boolean update(@PathVariable long id, @RequestBody CatCard card) throws CatCardNotFoundException{
        return catCardDao.update(id, card);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable long id) throws CatCardNotFoundException{
        return catCardDao.delete(id);
    }

}
