package in.pw.ioi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import in.pw.ioi.model.Student;

@Repository("dao")
public interface IStudentDao extends CrudRepository<Student, Integer>, PagingAndSortingRepository<Student, Integer> {

}
