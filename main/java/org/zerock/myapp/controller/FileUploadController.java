package org.zerock.myapp.controller;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Log4j2
@NoArgsConstructor

@Controller
public class FileUploadController {
//    @Setter(onMethod_ = @Autowired)
//    private MultipartResolver multipartResolver;

    @GetMapping("/fileUpload")
    String fileUploadView() {    // View-Controller
        log.trace("fileUploadView() invoked.");

        return "fileUploadView";
    } // fileUploadView


    @PostMapping("/fileUpload")
    String fileUpload(List<MultipartFile> files, String name) throws IOException {
        log.trace("fileUpload({},{}) invoked.",files, name);

        for (MultipartFile file: files) {
            log.info("\t 1. {}",file.getName());
            log.info("\t 2. {}",file.getContentType());
            log.info("\t 3. {}",file.getSize());
            log.info("\t 4. {}",file.isEmpty());
            log.info("\t 5. {}",file.getOriginalFilename());
            if(!file.isEmpty()) {  // 이 조건에서만 파일저장

                DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                String today = formatter.format(new Date());
                File uploadPath = new File("C:/temp/upload/"+today);
                if( !uploadPath.exists() ) {
                    uploadPath.mkdirs();
                }

                Path path = Path.of(uploadPath.getAbsolutePath()+File.separator+file.getOriginalFilename());
                log.info("\t path: {}", path);

                file.transferTo(path);
                log.info("\t isTransferOK: TRUE");
            } // if

        } // enhanced

        return "Done";
    } // fileUpload

} // end class
