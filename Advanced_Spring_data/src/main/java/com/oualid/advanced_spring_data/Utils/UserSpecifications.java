package com.oualid.advanced_spring_data.Utils;

import com.oualid.advanced_spring_data.dto.UserDto;
import com.oualid.advanced_spring_data.models.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UserSpecifications {

    public static Specification<User> UserNameLike(String like){
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("firstName"), like + '%');
            }
        };
    }

    public static Specification<User> UserByMulCond(UserDto user){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (user != null){
                predicates.add(criteriaBuilder.equal(root.get("firstName"),user.getFirstName()));
                predicates.add(criteriaBuilder.greaterThan(root.get("id"),5));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }


}
