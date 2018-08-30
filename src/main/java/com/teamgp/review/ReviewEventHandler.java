package com.teamgp.review;

import com.teamgp.user.User;
import com.teamgp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Review.class)
public class ReviewEventHandler {
  private final UserRepository users;

  @Autowired
  public ReviewEventHandler(UserRepository users) {
    this.users = users;
  }

  @HandleBeforeCreate
  public void addReviewerBasedOnLoggedInUser(Review review){
    String userName = SecurityContextHolder.getContext().getAuthentication().getName();
    User user = users.findByUserName(userName);
    review.setReviewer(user);
  }
}
