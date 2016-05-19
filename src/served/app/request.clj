(ns served.app.request)

(defn lookup-route [request routes-map]
  (let [requested-route (:uri request)]
  (let [matching-route  (some #(if (-> % :path (= requested-route)) %) routes-map)]
  (assoc request :matching-route matching-route)))
)
