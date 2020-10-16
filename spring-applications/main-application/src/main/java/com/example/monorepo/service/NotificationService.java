package com.example.monorepo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    private static final long TEN_SECONDS = 10000L;

    @Scheduled(fixedRate = TEN_SECONDS)
    public void cleanDatabase(){
        // [Sample Example]
        // ZonedDateTime now = ZonedDateTime.now();
        // int deleteCount = sampleRepository.deleteAllByTimestamp(now.minusDays(7));
        int deleteCount = 3;
        log.warn("{} number of old logs have been deleted by a scheduled service", deleteCount);
    }
}
