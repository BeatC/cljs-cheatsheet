(defproject cljs-cheatsheet "0.1.0"

  :description "A ClojureScript Cheatsheet"
  :url "https://github.com/oakmac/cljs-cheatsheet"

  :license {:name "MIT License"
            :url "https://github.com/oakmac/cljs-cheatsheet/blob/master/LICENSE.md"
            :distribution :repo}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [cljsjs/jquery "2.1.4-0"]
                 [com.cognitect/transit-cljs "0.8.237"]
                 [hiccups "0.3.0"]]

  :plugins [[lein-cljsbuild "1.1.2"]]

  :source-paths ["src"]

  :clean-targets ["app.js"
                  "public/js/cheatsheet.js"
                  "public/js/cheatsheet.min.js"
                  "target"]

  :cljsbuild
    {:builds
      [{:id "cheatsheet-dev"
        :source-paths ["cljs-client" "cljs-shared"]
        :compiler {:output-to "public/js/cheatsheet.js"
                   :optimizations :whitespace}}

       {:id "cheatsheet-prod"
        :source-paths ["cljs-client" "cljs-shared"]
        :compiler {:output-to "public/js/cheatsheet.min.js"
                   :optimizations :advanced
                   :pretty-print false}}

       {:id "server"
        :source-paths ["cljs-server" "cljs-shared"]
        :compiler {:language-in :ecmascript5
                   :language-out :ecmascript5
                   :output-to "app.js"
                   :optimizations :simple
                   :target :nodejs}}]})
