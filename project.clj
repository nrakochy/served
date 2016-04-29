(defproject served "0.1.0-SNAPSHOT"
  :description "Exploration of Ring"
  :url "http://example.com/nothing-to-see-here"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
		  [ring/ring-core "1.4.0"]
		  [http-kit "2.2.0-alpha1"]
		  ]
  :uberjar {:aot :all}
  :main served.main
  :aot [served.main])
