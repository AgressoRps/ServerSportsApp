package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.RankWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/rank")
public class RankController {

    private final RankService rankService;

    @Autowired
    public RankController(RankService rankService){
        this.rankService = rankService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<RankWrapper> getAllRanks() throws ServerException{
        return rankService.getAllRanks();
    }
}
