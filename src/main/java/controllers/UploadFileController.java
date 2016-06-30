package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import utils.FileUploadUtilite;

import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny_Akulenko on 6/27/2016.
 */
@Controller
public class UploadFileController {
    private static final Logger logger = LoggerFactory.getLogger(UploadFileController.class);
    @Autowired
    private FileUploadUtilite fileUploadUtilite;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ModelAndView handleFormUpload(MultipartHttpServletRequest request) throws Exception {

        ModelAndView model = new ModelAndView();

        Map<String, MultipartFile> fileMap = request.getFileMap();

        if (!fileMap.isEmpty()) {
            List<String> dataList = fileUploadUtilite.parseFile(fileMap);
            model.addObject("dataList", dataList);
            model.setViewName("uploadedFile");
        }
        return model;
    }


}
