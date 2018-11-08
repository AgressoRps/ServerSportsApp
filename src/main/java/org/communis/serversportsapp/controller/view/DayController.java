package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.DayWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.repository.DayRepository;
import org.communis.serversportsapp.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/day")
public class DayController {

    private final DayService dayService;

    @Autowired
    public DayController(DayService dayService){
        this.dayService = dayService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<DayWrapper> getAllDays() throws ServerException{
        return dayService.getAllDays();
    }

}
