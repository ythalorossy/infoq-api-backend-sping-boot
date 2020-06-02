package com.example.copsboot.report;

import com.example.copsboot.user.UserId;
import com.example.copsboot.user.UserService;
import com.example.copsboot.user.web.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.ZonedDateTime;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    private ReportRepository repository;
    private UserService userService;

    public ReportServiceImpl(ReportRepository reportRepository, UserService userService) {

        this.repository = reportRepository;
        this.userService = userService;
    }

    @Override
    public Report createReport(UserId reportId, ZonedDateTime dateTime, String description, MultipartFile image) {
        return repository.save(new Report(repository.nextId(),
                userService.getUser(reportId).orElseThrow(() -> new UserNotFoundException(reportId)),
                dateTime,
                description));
    }
}
