package smartbox.integrity_checks.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import smartbox.integrity_checks.models.SMB;

import java.util.Optional;

@FeignClient("TMS")
public interface SMBInterface {
    @GetMapping("/getSMBbyID")
    public Optional<SMB> GetSMBbyID(@RequestParam String id);
}
