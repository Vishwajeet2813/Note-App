package com.example.notes.services;

import com.example.notes.models.AuditLog;
import com.example.notes.models.Note;

import java.util.List;

public interface AuditLogService {

    public void logNoteCreation(String username, Note note);

    public void logNoteUpdation(String username, Note note);

    void logNoteDeletion(String username, Long noteId);

    List<AuditLog> getAllAudits();

    List<AuditLog> getAllAuditForNote(Long id);
}
