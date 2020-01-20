package com.inti.formation.iservices;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.inti.formation.entities.ChapterFile;
import com.inti.formation.utils.CrudOperation;

public interface IFileChapterService extends CrudOperation<ChapterFile> {

	ChapterFile storeChapter(MultipartFile file, Long id);

    List<ChapterFile> storeChapters(MultipartFile[] files, Long id);


}
