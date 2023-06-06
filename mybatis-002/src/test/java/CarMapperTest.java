import com.wen.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author wen
 * @Data 2023/6/2 19:10
 */
public class CarMapperTest {
    @Test
    public void TextSelect(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object car = sqlSession.selectOne("selectcar",1);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void TestSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Object> cars = sqlSession.selectList("selectAllcar");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }
}
