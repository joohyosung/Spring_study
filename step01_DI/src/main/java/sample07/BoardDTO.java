package sample07;

import lombok.*;
import org.springframework.stereotype.Repository;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = {"no"})
@Repository
@RequiredArgsConstructor
public class BoardDTO {
    @NonNull
    private int no;
    private String subject;
    private String content;
}
