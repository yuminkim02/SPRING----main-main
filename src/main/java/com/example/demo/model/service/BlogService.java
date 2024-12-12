package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.domain.Board;
import com.example.demo.model.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 생성자 자동 생성(부분)
public class BlogService {
    @Autowired // 객체 주입 자동화, 생성자 1개면 생략 가능
    private final BoardRepository blogRepository; // 리포지토리 선언

    public Board save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
    
    public List<Board> findAll(){
        return blogRepository.findAll();
    }

    public Optional<Board> findById(Long id){
        return blogRepository.findById(id);
    }
    
    public Page<Board> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
    
    public Page<Board> searchByKeyword(String keyword, Pageable pageable) {
        return blogRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    } // LIKE 검색 제공(대소문자 무시)

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }
    
}