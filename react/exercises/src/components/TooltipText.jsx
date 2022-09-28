import { useRef, useState } from "react"
import Tooltip from "./Tooltip"

function TooltipText (props) {
    const tooltipElement = useRef()
    const [tooltipDomRect, setTooltipDomRect] = useState({})
    const [showTooltip, setShowTooltip] = useState(false)

    function handleMouseOver (event) {
        const domData = tooltipElement.current.getBoundingClientRect()
        setTooltipDomRect(domData)
        setShowTooltip(true)
    }
    return (
        <>
            <span className="tooltip-text" ref={tooltipElement}
                onMouseOver={event => handleMouseOver(event)}
                onMouseLeave={ev => setShowTooltip(false)}>
                {props.children}
            </span>
            {
                showTooltip && <Tooltip domRect={tooltipDomRect} tooltip={props.tooltip}  />
            }
        </>
    )
}

export default TooltipText
