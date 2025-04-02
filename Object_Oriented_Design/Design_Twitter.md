```
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.

Example 1:

Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]
```

Link: https://leetcode.com/problems/design-twitter/description/

Solution-1: Without Heap
```
from datetime import datetime

class Tweet:
    def __init__(self, userId: int, tweetId: string):
        self.userId = userId
        self.time = datetime.now()

class Twitter:

    def __init__(self):
        followerMap = defaultdict(set)
        # user and list of their tweets
        tweetMap = defaultdict(list)

    def postTweet(self, userId: int, tweetId: int) -> None:
        tweet = Tweet(userId, tweetId)
        self.tweetMap[userId].append(tweet)


    def getNewsFeed(self, userId: int) -> List[int]:
        # filter with followed account for the userID
        followeeIds = self.followerMap[userId]

        tweets = []
        for fi in followeeIds:
            tweets.append(tweetMap[fi])
        tweets.append(tweetMap[userId])

        sortedTweets = [sorted(tweets, key = lambda tweet: tweet.time, reverse=True)]

        return sortedTweets[10:]

    def follow(self, followerId: int, followeeId: int) -> None: 
        self.followerMap[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.followerMap[followerId].remove(followeeId)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)
```


Solution-2: With Min Heap (Python has default Min-Heap) \
Idea: Decrease timestamp for each tweet to use Min-Heap \
Store all required data with each heap node so that more DS are not needed to get other info

```
class Twitter:

    def __init__(self):
        self.count=0
        self.following=defaultdict(set)
        self.post=defaultdict(list)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.post[userId].append([self.count,tweetId])
        self.count-=1

    def getNewsFeed(self, userId: int) -> List[int]:
        self.following[userId].add(userId)
        minHeap=[]
        for followee in self.following[userId]:
            i=len(self.post[followee])-1
            if i>=0:
                count,tweetId=self.post[followee][i]
                minHeap.append([count,tweetId,followee,i])
        heapq.heapify(minHeap)
        res=[]

        while minHeap and len(res)<10:
            count,tweetId,followee,index=heapq.heappop(minHeap)
            res.append(tweetId)
            if index>0:
                count,tweetId=self.post[followee][index-1]
                heapq.heappush(minHeap, [count,tweetId,followee,index-1])
        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        self.following[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId in self.following[followerId]:
            self.following[followerId].remove(followeeId)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)
```
