class Twitter {
    private class Tweet{
        int tweetId;
        int time;

        Tweet(int tweetId, int time)
        {
            this.tweetId = tweetId;
            this.time =  time ; 
        }
    }

    private class User{
        int userId;
        List<Tweet> tweets;
        Set<Integer> followee;
        User(int userId)
        {
            this.userId =  userId; 
            tweets =  new LinkedList(); 
            followee = new HashSet<>(); 
        }
        public void tweet(int tweetId , int time)
        {
            Tweet t = new Tweet(tweetId, time);
            tweets.addFirst(t); 
            if(tweets.size()>10)
                tweets.removeLast();
        }
        public void addFollowee(int followeeId)
        {
            followee.add(followeeId);
        }
        public void removeFollowee(int followeeId)
        {
            followee.remove(followeeId);
        }
    }
    private int TIME = 0;

    Map<Integer, User> users;
    
    public Twitter() {
        users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        users.putIfAbsent(userId, new User(userId));
        users.get(userId).tweet(tweetId, TIME++);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        users.putIfAbsent(userId, new User(userId));

        User user = users.get(userId); 
        PriorityQueue<Tweet> feed = new PriorityQueue<Tweet>((a,b)->Integer.compare(a.time, b.time)); 
        user.tweets.stream().forEach(t->feed.offer(t));

        user.followee.stream().flatMap(u->users.get(u).tweets.stream()).forEach(
            t->{
                feed.offer(t);
                if(feed.size()>10)
                feed.poll();
            }
        );
        List<Integer> result = new ArrayList<>();
        while(!feed.isEmpty()) {
            result.add(feed.poll().tweetId);
        }

        Collections.reverse(result);
        return result;
        

    }

    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));
        users.get(followerId).addFollowee(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));
        users.get(followerId).removeFollowee(followeeId);
    }
}
