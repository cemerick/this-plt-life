(ns cemerick.this-plt-life
  (:require [net.cgrand.enlive-html :as en]))

(defn pull [dest-dir]
  (let [dir (java.io.File. dest-dir)
        url-base "http://this-plt-life.tumblr.com/page/%s"]
    (.mkdir dir)
    (->> (range 1 9)
         (mapcat #(en/select (en/html-resource (java.net.URL. (format url-base %))) [:.post]))
         reverse
         (map-indexed vector)
         (reduce
          (fn [_ [number post]]
            (let [heading (en/select post [:h2])
                  title (apply str (en/texts heading))
                  post-url (-> (en/select heading [:a]) first :attrs :href)
                  filename (-> (.toLowerCase title)
                               (.replaceAll "\\s+" "-")
                               (.replaceAll "[^a-z0-9-]" "")
                               (str ".gif"))
                  gif-url (->> (en/select post [:img])
                               (map #(-> % :attrs :src))
                               (map clojure.string/trim)
                               ; a couple posts have gifs with .jpg urls
                               (filter #(re-find #"(?i)\.(gif|jpg)$" %))
                               first)
                  file (java.io.File. dir (str (format "%02d-" number) filename))]
              (when-not (.exists file)
                (if-not gif-url
                  (println "no gif for" post-url)
                  (java.nio.file.Files/copy
                   (.openStream (java.net.URL. gif-url))
                   (.toPath file)
                   (into-array java.nio.file.StandardCopyOption []))))))
          nil))))

(defn -main [& [dest-dir]]
  (pull (or dest-dir "this-plt-life")))
