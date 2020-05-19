(ns gorilla-ui-example.main
  (:require [reagent.dom :as rdom]
            [pinkgorilla.ui.pinkie :refer [tag-inject renderer-list]]
            [pinkgorilla.ui.default-renderer]))

(def app
  [:div
   [:p/vega {:$schema     "https://vega.github.io/schema/vega-lite/v4.json"
             :description "A scatter plot."
             :data        {:values (for [i (range 99)]
                                     {:x i
                                      :y (+ i (* i 9 (rand)))})}
             :mark        :point
             :encoding    {:x {:field :x :type :quantitative}
                           :y {:field :y :type :quantitative}}}]])

(defn mount [app]
  (rdom/render (tag-inject app)
               (.getElementById js/document "app")))

(defn reload! []
  (mount app)
  (print "Hello reload!"))

(defn main! []
  (mount app)
  (print "Hello Main"))
