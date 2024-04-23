package org.keycloak.bootkeycloaktoken.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping( "/permitAll")
    public String permitAll() {
        return "누구나 접근이 가능합니다.";
    }

    @GetMapping( "/authenticated")
    public String authenticated(@RequestHeader String Authorization) {
        log.debug(Authorization);
        return "로그인한 사람 누구나 가능합니다.";
    }

    @PreAuthorize("hasAnyRole('alertRole')")
    @GetMapping( "/alert")
    public String alert() {
        return "alertRole 가능합니다.";
    }

    @PreAuthorize("hasAnyRole('alertReadRole')")
    @GetMapping( "/alert/read")
    public String alertRead() {
        return "alertReadRole 가능합니다.";
    }

    @PreAuthorize("hasAnyRole('cwslogRole')")
    @GetMapping( "/cwslog")
    public String cwslog(@RequestHeader String Authorization) {
        log.debug(Authorization);
        return "cwslogRole 가능합니다";
    }

    @PreAuthorize("hasAnyRole('cwslogReadRole')")
    @GetMapping( "/cwslog/read")
    public Map cwslogReadRole(@RequestHeader String Authorization) {
        log.debug(Authorization);
//        return "cwslogReadRole 가능합니다.";
        return Map.of("test", Authorization);
    }


    @PreAuthorize("hasAnyRole('cwslogDownloadRole')")
    @GetMapping( "/cwslog/download")
    public String cwslogDownload(@RequestHeader String Authorization) {
        log.debug(Authorization);
        return "cwslogDownloadRole 가능합니다.";
    }

}
