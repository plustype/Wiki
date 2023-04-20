package com.steven.wiki.controller;

import com.steven.wiki.request.EbookReq;
import com.steven.wiki.response.CommonResp;
import com.steven.wiki.response.EbookResp;
import com.steven.wiki.response.PageResp;
import com.steven.wiki.service.EbookService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebook")  //put common path before class to apply to all requests
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookReq req) {
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
        PageResp<EbookResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/all")
    public CommonResp all() {
        CommonResp<List<EbookResp>> resp = new CommonResp<>();
        List<EbookResp> all = ebookService.all();
        resp.setContent(all);
        return resp;
    }
}
