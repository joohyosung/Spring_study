package sample07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardMyBatisDAOImpl;
    @Autowired
    @Qualifier("boardOracleDAOImpl")
    private BoardDAO boardOracleDao;

    public BoardServiceImpl() {
        System.out.println("BoardServiceImpl 생성자 호출");
    }

    @PostConstruct
    public void init(){
        System.out.println("boardMyBatisDAOImpl = "+boardMyBatisDAOImpl);
        System.out.println("boardOracleDao = "+boardOracleDao);
    }

    @Override
    public void select() {
        System.out.println("BoardService select call");
        boardMyBatisDAOImpl.select();
        boardOracleDao.select();
    }
}
