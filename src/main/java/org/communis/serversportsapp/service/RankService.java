package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.RankWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class RankService {

    private final RankRepository rankRepository;

    @Autowired
    public RankService(RankRepository rankRepository){
        this.rankRepository = rankRepository;
    }

    public List<RankWrapper> getAllRanks() throws ServerException{
        try {
            return rankRepository.findAll().stream().map(RankWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.RANK_LIST_ERROR), ex);
        }
    }
}
