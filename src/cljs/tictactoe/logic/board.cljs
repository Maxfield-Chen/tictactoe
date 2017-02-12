(ns tictactoe.logic.board
  (:require
    [tictactoe.logic.constants :as cst]
    [tictactoe.utils :as utils]))


(defn new-empty-board
  []
  cst/empty-board)

(defn convert-cell
  [board player x y]
  (assoc board [x y] player))

(defn empty-position?
  [board x y]
  (= (get board [x y]) :cell/empty))

(defn full?
  [board]
  (not-any? #{:cell/empty} (map second board)))

(defn one-owner?
  [board positions]
  (let [owners (utils/get-all board positions)]
    (and
      (not-any? #{:cell/empty} owners)
      (= 1 (count (set owners)))
      )))

(defn get-size [_] cst/board-size)
(defn get-cells [board] board)
