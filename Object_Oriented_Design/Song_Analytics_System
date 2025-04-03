```
Problem Statement: Design a Song Play Analytics System

Design a system to track song plays and generate analytics based on the number of unique listeners per song. Implement the SongAnalytics class with the following methods:

SongAnalytics()
Initializes the system.

int add_song(string name)
Adds a song to the system, assigns it a unique auto-incrementing ID starting from 1, and returns the assigned ID.

void play_song(int song_id, int user_id)
Records a play event for a song by a user.

If song_id does not exist, output: Error: Song ID <song_id> does not exist. (replace <song_id> with the invalid ID).
Each user is counted once per song, even if they play it multiple times.
void print_analytics()
Prints a summary of all songs sorted by the number of unique listeners in descending order.

If two songs have the same number of unique listeners, sort them lexicographically by name in ascending order.
Each line in the output should follow the format: <song_name> (<count> unique listeners).
Example:

Input:
add_song("Song A") → returns 1  
add_song("Song B") → returns 2  
add_song("Song C") → returns 3  
play_song(1, 1)  
play_song(1, 2)  
play_song(2, 1)  
play_song(3, 3)  
play_song(3, 3)  
print_analytics()  

Output:
Song A (2 unique listeners)  
Song B (1 unique listeners)  
Song C (1 unique listeners)  
Explanation:

"Song A" has 2 unique listeners.
"Song B" and "Song C" both have 1 unique listener. They are sorted lexicographically by name ("Song B" before "Song C").
Note:

Ensure the solution efficiently handles multiple calls to play_song and print_analytics.
```



```python
class SongAnalytics:

    # repo for songs
    # map for play event
    def __init__(self):
        # key is song_id and val is song
        self.songs = defaultdict()
        # key is song id and value is set
        self.play_event = defaultdict(set)
        self.songId = 0
        self.play_list = defaultdict(list)

    # Adds a song to the system, assigns it a unique auto-incrementing ID starting from 1, and returns the assigned ID.
    def add_song(self, name: String) -> int:
        self.songId += 1
        self.songs[songId] = name
        self.play_event[name] = set()
        return songId

    # Records a play event for a song by a user.
    # If song_id does not exist, output: Error: Song ID <song_id> does not exist. (replace <song_id> with the invalid ID).
    # Each user is counted once per song, even if they play it multiple times.
    def play_song(self, song_id:int, user_id:int)
        if song_id not in self.play_event:
            print(f"Error: Song ID {song_id} does not exist."
            return
        self.play_event[song_id].add(user_id)
        if song_id not in play_list[user_id].values():
            self.play_list[user_id].add(song_id)
            if len(self.play_list[user_id]) > 3:
                self.play_list[user_id].pop(0)

    # Prints a summary of all songs sorted by the number of unique listeners in descending order.
    # If two songs have the same number of unique listeners, sort them lexicographically by name in ascending order.
    # Each line in the output should follow the format: <song_name> (<count> unique listeners).x
    def print_analytics(self):
        sorted_play_event = sorted(self.play_event.items(), key=lamda item: (-len(item[1]), item[0]), reverse=True)
        for k,v in sorted_play_event.items():
            print(k + " " + len(v))

    # get last 3 unique songs played by a given user
    def getLastThreeSongs(self, user_id: int) -> String: 
        return [self.songs[song_id] for song_id in self.play_list[user_id][-3:]]

```
