package com.zxw.dao;


import com.zxw.domain.storyImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
public interface storyImageRepository extends JpaRepository<storyImage, Long>{
    //这里的ImageRepository继承自JpaRepository，泛型参数Image是你实体类的类型，Long是实体类主键的类型。
    // Spring Data JPA会自动为你生成基本的CRUD（Create, Read, Update, Delete）操作方法，如save, findById, findAll, deleteById等，所以你无需手动编写SQL语句或Mapper接口。
    //如果你确实需要更复杂的查询，可以在ImageRepository接口中声明查询方法，Spring Data JPA会根据方法名自动生成SQL语句。例如，如果你想根据图片名称查找图片，可以添加如下方法：
    //Java
    //public interface ImageRepository extends JpaRepository<Image, Long> {Optional<Image> findByImageUrl(String imageUrl);}
    //这样，你就可以直接在服务类ImageServiceImpl中注入并使用ImageRepository来进行数据库操作，而不需要额外的Mapper类。Spring Data JPA的强大之处在于它能够大大简化数据访问层的编码工作，提高开发效率。
    List<storyImage> findAllByUserId( @Param("userId") int userId);
    
    storyImage save(storyImage image);

    List<storyImage> findAll();
}
