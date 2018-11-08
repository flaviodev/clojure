(defproject hangmangame "0.1.0-SNAPSHOT"
  :description "hangman game"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot hangmangame.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
  :repositories [["jitpack" "https://jitpack.io"]
                 ["central" "https://repo1.maven.org/maven2"]
                 ["clojure" "https://build.clojure.org/releases"]
                 ["clojars" "https://clojars.org/repo"]
                 ["java.net" "https://download.java.net/maven/2"]
                 ["jboss.release" "https://repository.jboss.org/nexus/content/groups/public"]
                 ["terracotta-releases" "https://www.terracotta.org/download/reflector/releases"]
                 ["terracotta-snapshots" "https://www.terracotta.org/download/reflector/snapshots"]
                 ["apache.snapshots" "https://repository.apache.org/snapshots"]]
