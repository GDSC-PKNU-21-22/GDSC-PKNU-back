package com.gdsc.pknu.backend.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gdsc.pknu.backend.controller.ApiRes;
import com.gdsc.pknu.backend.service.MajorService;


@RestController
@RequestMapping("api/major")
public class MajorRestController {
    
    @Autowired
    private final MajorService majorService;

    public MajorRestController(MajorService majorService) {
        this.majorService = majorService;
    }

    @GetMapping()
    public ApiRes<MajorListResult> getMajorList() {
        return ApiRes.SUCCESS(new MajorListResult(majorService.getMajorList()));
    }
}
