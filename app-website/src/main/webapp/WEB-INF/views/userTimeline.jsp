<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">

  <!-- Timeline
      ================================================= -->
  <div class="timeline">
    <div class="timeline-cover">

      <!--Timeline Menu for Large Screens-->
      <div class="timeline-nav-bar hidden-sm hidden-xs">
        <div class="row">
          <div class="col-md-3">
            <div class="profile-info">
              <img src="http://placehold.it/300x300" alt="" class="img-responsive profile-photo" />
              <h3>${user.firstName}${user.lastName}</h3>
              <p class="text-muted">Creative Specialist</p>
            </div>
          </div>
          <div class="col-md-9">
            <ul class="list-inline profile-menu">
              <li><a href="<c:url value="/${user.userName}"></c:url>" class="active">Timeline</a></li>
              <li><a href="<c:url value="/${user.userName}/about"></c:url>">About</a></li>
              <li><a href="<c:url value="/${user.userName}/album"></c:url>">Album</a></li>
              <li><a href="<c:url value="/${user.userName}/friends"></c:url>">Friends</a></li>
            </ul>
            <c:if test="${loginedUser != null && loginedUser.userName != user.userName}">
              <ul class="follow-me list-inline">
                <li>1,299 followers</li>
                <li><c:if test="${followed == false}">
                    <a href="<spring:url value="/user/follow?userId=${user.id}"/>"
                      class="btn btn-success pull-right"> <span
                      class="glyphicon-shopping-cart glyphicon"></span> follow
                    </a>
                  </c:if> <c:if test="${followed == true}">
                    <a href="<spring:url value="/user/unfollow?userId=${user.id}"/>"
                      class="btn btn-danger pull-right"> <span
                      class="glyphicon-shopping-cart glyphicon"></span> unfollow
                    </a>
                  </c:if></li>
              </ul>
            </c:if>
          </div>
        </div>
      </div>
      <!--Timeline Menu for Large Screens End-->

      <!--Timeline Menu for Small Screens-->
      <div class="navbar-mobile hidden-lg hidden-md">
        <div class="profile-info">
          <img src="http://placehold.it/300x300" alt="" class="img-responsive profile-photo" />
          <h4>Sarah Cruiz</h4>
          <p class="text-muted">Creative Director</p>
        </div>
        <div class="mobile-menu">
          <ul class="list-inline">
            <li><a href="<c:url value="/${user.userName}"></c:url>" class="active">Timeline</a></li>
            <li><a href="<c:url value="/${user.userName}/about"></c:url>">About</a></li>
            <li><a href="<c:url value="/${user.userName}/album"></c:url>">Album</a></li>
            <li><a href="<c:url value="/${user.userName}/friends"></c:url>">Friends</a></li>
          </ul>
          <c:if test="${loginedUser != null && loginedUser.userName != user.userName}">
            <button class="btn-primary">Add Friend</button>
          </c:if>
        </div>
      </div>
      <!--Timeline Menu for Small Screens End-->

    </div>
    <div id="page-contents">
      <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-7">
          <c:if test="${loginedUser != null}">
            <!-- Post Create Box
              ================================================= -->
            <div class="create-post">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                  <div class="form-group">
                    <img src="http://placehold.it/300x300" alt="" class="profile-photo-md" />
                    <textarea name="texts" id="exampleTextarea" cols="30" rows="1"
                      class="form-control" placeholder="Write what you wish"></textarea>
                  </div>
                </div>
                <div class="col-md-5 col-sm-5">
                  <div class="tools">
                    <ul class="publishing-tools list-inline">
                      <li><a href="#"><i class="ion-compose"></i></a></li>
                      <li><a href="#"><i class="ion-images"></i></a></li>
                      <li><a href="#"><i class="ion-ios-videocam"></i></a></li>
                      <li><a href="#"><i class="ion-map"></i></a></li>
                    </ul>
                    <button class="btn btn-primary pull-right">Publish</button>
                  </div>
                </div>
              </div>
            </div>
            <!-- Post Create Box End-->
          </c:if>
          <c:if test="${loginedUser == null}">
            <!-- Currently just Fill out the empty space if Post Create Box is not shown
              ================================================= -->
            <div class="create-post">
              <div class="row">
                <div class="about-content-block">
                  <h4 class="grey">
                    <i class="ion-ios-information-outline icon-in-title"></i>What is life?
                  </h4>
                  <p>For me, just like, enterprise, explore, experiment, expand, exploit,
                    experience, evolve, eternity.</p>
                  <p>So, take it easy, and still: Work hard, Good luck!</p>
                </div>
              </div>
            </div>
            <!-- Post Create Box End-->
          </c:if>
          <c:forEach items="${posts}" var="post">
            <!-- Post Content
              ================================================= -->
            <div class="post-content">

              <!--Post Date-->
              <div class="post-date hidden-xs hidden-sm">
                <h5>${post.userNameDisplaying}</h5>
                <p class="text-grey">${post.createdDate}</p>
              </div>
              <!--Post Date End-->

              <img src="<c:url value="/img/${post.id}.png"></c:url>" alt="post-image"
                class="img-responsive post-image" />
              <div class="post-container">
                <img src="http://placehold.it/300x300" alt="user" class="profile-photo-md pull-left" />
                <div class="post-detail">
                  <div class="user-info">
                    <h5>
                      <a href="timeline.html" class="profile-link">${post.userNameDisplaying}</a> <span
                        class="following">following</span>
                    </h5>
                    <p class="text-muted">${post.createdDate}</p>
                  </div>
                  <div class="reaction">
                    <a class="btn text-green"><i class="icon ion-thumbsup"></i> 13</a> <a
                      class="btn text-red"><i class="fa fa-thumbs-down"></i> 0</a>
                  </div>
                  <div class="line-divider"></div>
                  <div class="post-text">
                    <p>${post.content}</p>
                  </div>
                  <div class="line-divider"></div>
                  <!-- <div class="post-comment">
                      <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm" />
                      <p><a href="timeline.html" class="profile-link">Diana </a><i class="em em-laughing"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud </p>
                    </div>
                    <div class="post-comment">
                      <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm" />
                      <p><a href="timeline.html" class="profile-link">John</a> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud </p>
                    </div> -->
                </div>
              </div>
            </div>
          </c:forEach>


        </div>
        <div class="col-md-2 static">
          <div id="sticky-sidebar">
            <h4 class="grey">${user.firstName}'sactivity</h4>
            <div class="feed-item">
              <div class="live-activity">
                <p>
                  <a href="#" class="profile-link">${user.firstName}</a> Commended on a Photo
                </p>
                <p class="text-muted">5 mins ago</p>
              </div>
            </div>
            <div class="feed-item">
              <div class="live-activity">
                <p>
                  <a href="#" class="profile-link">${user.firstName}</a> Has posted a photo
                </p>
                <p class="text-muted">an hour ago</p>
              </div>
            </div>
            <div class="feed-item">
              <div class="live-activity">
                <p>
                  <a href="#" class="profile-link">${user.firstName}</a> Liked her friend's post
                </p>
                <p class="text-muted">4 hours ago</p>
              </div>
            </div>
            <div class="feed-item">
              <div class="live-activity">
                <p>
                  <a href="#" class="profile-link">${user.firstName}</a> has shared an album
                </p>
                <p class="text-muted">a day ago</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

