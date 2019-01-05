package pub.liyf.model;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pub.liyf.common.TxQueryRunner;
import pub.liyf.exception.PersonNotFoundException;
import pub.liyf.model.bean.Employee;
import pub.liyf.model.bean.Person;
import pub.liyf.model.bean.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelDateBaseImpl implements Model{
    
    private QueryRunner queryRunner = new TxQueryRunner();
    
    @Override
    public void insert(Class clazz) {
        if(clazz.equals(Student.class)){
            String sql = "insert into";
        }

        if(clazz.equals(Employee.class)){

        }
    }

    @Override
    public List<Person> getAll(Class clazz) {
        ArrayList<Person> list = new ArrayList<>();
        if(clazz.equals(Student.class)){
            String sql = "select * from student";
            try {
                List<Student> students = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
                list.addAll(students);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        
        if(clazz.equals(Employee.class)){
            String sql = "select * from employee";
            try {
                List<Employee> employees = queryRunner.query(sql, new BeanListHandler<Employee>(Employee.class));
                list.addAll(employees);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Person getById(String id, Class clazz) throws PersonNotFoundException {
        Person person = null;
        if (clazz.equals(Employee.class)) {
            String sql = "select * from employee where id=?";
            try {
                person = queryRunner.query(sql, new BeanHandler<Employee>(Employee.class),id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(clazz.equals(Student.class)){
            String sql = "select * from student where id=?";
            try {
                person = queryRunner.query(sql, new BeanHandler<Student>(Student.class),id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(person == null){
            throw new PersonNotFoundException("没有找到id为" + id + "的人!");
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
