(ns served.middleware.route)

(defn associate-path [resource path]
  (assoc resource :path path)
)

(defn add-paths [route-map]
  (map 
    #(if (contains? % :root_path)
      (associate-path % "/")
      (associate-path % (str "/" (get % :name)))
     ) route-map)
)

(defn compile-routes [resources]
   (-> resources 
      (add-paths))
)


