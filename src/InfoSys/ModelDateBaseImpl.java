package InfoSys;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import InfoSys.VO.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelDateBaseImpl implements Model{
    
    private QueryRunner queryRunner = new TxQueryRunner();
    
    public void insert(Class clazz) {
        if(clazz.equals(Student.class)){
            String sql = "insert into";
        }
    }
    public List<Student> getAll(Class clazz) {
        ArrayList<Student> list = new ArrayList<>();
        if(clazz.equals(Student.class)){
            String sql = "select * from student";
            try {
                List<Student> students = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
                list.addAll(students);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return list;
    }
    public Student getById(String id, Class clazz) throws Exception {
        Student person = null;
        if(clazz.equals(Student.class)){
            String sql = "select * from student where id=?";
            try {
                person = queryRunner.query(sql, new BeanHandler<Student>(Student.class),id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(person == null){
            throw new Exception("没有找到id为" + id + "的人!");
        }
        return person;
    }

    @Override
    public List<Person> getByLike(String partOfName, Class clazz) throws PersonNotFoundException {
        List<Person> list = new ArrayList<>();

        return null;
    }

    @Override
    public void delete(String id, Class clazz) throws PersonNotFoundException {

    }

    @Override
    public void update(String id, Class clazz) {

    }
}
