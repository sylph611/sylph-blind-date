package org.sylph.blinddate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sylph.blinddate.controller.dto.ParticipantDto;
import org.sylph.blinddate.service.ParticipantService;

@RestController("/api/participants")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;
    // GET /api/participants: 모든 참여자 목록 조회. 를 만들어줘
    @GetMapping
    public ResponseEntity<Page<ParticipantDto>> getParticipants(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(participantService.getParticipants(Pageable.ofSize(size).withPage(page)));
    }

    // GET /api/participants/{id}: 특정 참여자 상세 정보 조회.
    @GetMapping("/{id}")
    public ResponseEntity<?> getParticipant(@PathVariable Long id) {
        return null;
    }

    // POST /api/participants: 참여자 등록.
    @PostMapping
    public  ResponseEntity<?> saveParticipant() {
        return null;
    }

    //  PUT /api/participants/{id}: 참여자 정보 수정.
    @PutMapping("/{id}")
    public ResponseEntity<?> updateParticipant(@PathVariable Long id) {
        return null;
    }

    // DELETE /api/participants/{id}: 참여자 삭제.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParticipant(@PathVariable Long id) {
        return null;
    }

}
