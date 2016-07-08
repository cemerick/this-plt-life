
[This PLT Life](http://this-plt-life.tumblr.com/) is a great little tumblr that
captures a lot of common sentiments among programmers and amateur language
hackers. I got tired hunting around for a gif I remembered seeing the last time
I toured around the site, so I wrote up a little Clojure "script" to scrape them
all, name them appropriately, and dump them into a directory for easy tweeting
and such.

**Yes**, this _scrapes_ tumblr.com, since the RSS feed that tumblr provides is
nigh-useless (much like RSS generally and other "syndication" mechanisms we rarely have
available to us). Not very polite, but they leave me no choice.

## Where's the gifs!?

I stuffed mine into Dropbox; the directory they're in is public, and provides a
nice N-up lightbox of them all:

### [my this-plt-life gifs](https://www.dropbox.com/sh/d96rrv3dm00ph2q/AABYC8OFpXsqbVu2ftKYVOE9a?dl=0)

If you actually want to run the "script" in this project (why?):

```
$ lein run $DESTINATION_DIR
```

## (not) FAQ's

Yes, this could probably be used to scrape gifs from other tumblrs, but I've not
cared enough to bother checking.

Yes, this could probably be done in 4 lines of curl and awk. I mostly suck at
awk, and I have this other hammer.

## Thanks

Of course, this wouldn't exist if
[Manuel Simoni](http://axisofeval.blogspot.com/)
([@msimoni](https://twitter.com/msimoni/)) hadn't made This PLT Life in the first
place. Cheers!
