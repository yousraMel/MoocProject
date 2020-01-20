package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.ChapterFile;





public interface IFileChapterRepository extends JpaRepository<ChapterFile,Long> {
}
