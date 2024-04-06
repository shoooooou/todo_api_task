package springchatapp.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import springchatapp.demo.model.resource.TaskResource;

import java.util.List;

@Mapper
public interface TaskMapper {
    List<TaskResource> selectByUid(final String uid);
}
