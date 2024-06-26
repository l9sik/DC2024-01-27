package by.bsuir.news.discussion.dto.request;


import by.bsuir.news.discussion.entity.Note;
import by.bsuir.news.discussion.entity.NoteKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteRequestTo {
    private Locale locale;
    private Long id;
    private String content;
    private Long newsId;
    public static Note fromRequest(NoteRequestTo request) {
        Note note = new Note();
        note.setContent(request.content);
        note.setKey(new NoteKey(request.locale, request.id, request.newsId));
        return note;
    }
}
