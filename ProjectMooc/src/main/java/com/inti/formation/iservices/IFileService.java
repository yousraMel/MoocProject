package com.inti.formation.iservices;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.inti.formation.entities.Image;
import com.inti.formation.utils.CrudOperation;

public interface IFileService extends CrudOperation<Image> {

    Image storeImage(MultipartFile file, Long id);

    List<Image> storeImages(MultipartFile[] files, Long id);
}
